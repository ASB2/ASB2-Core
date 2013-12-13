package ASB2.utils;

import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;

public final class UtilFluid {

    public static boolean moveFluid(IFluidHandler source, ForgeDirection from, IFluidHandler destination, ForgeDirection to, boolean doMove) {

        int amount = 1000000;

        while (true) {

            if(!UtilFluid.moveFluid(source, from, to, destination, amount, doMove)) {

                if(amount >= 1000) {

                    amount = amount - 1000;
                }
                else if(amount >= 500) {

                    amount = amount - 10;
                }
                else {

                    return false;
                }
            }
            else {

                return true;
            }
        }
    }

    public static boolean moveFluid(IFluidHandler source, ForgeDirection from, ForgeDirection to, IFluidHandler destination, int amount, boolean doMove) {

        boolean isSuccessful = false;

        if(source != null && destination != null) {

            if(destination.getTankInfo(from) != null && source.getTankInfo(from) != null) {

                FluidStack fluidToMove = UtilFluid.removeFluidFromTankFluidStack(source, to, amount, false);

                if(fluidToMove != null) {

                    fluidToMove = fluidToMove.copy();

                    if(fluidToMove.amount >= amount) {

                        fluidToMove.amount = amount;

                        if(UtilFluid.addFluidToTank(destination, from, fluidToMove, false)) {

                            isSuccessful = true;

                            if(doMove) {

                                UtilFluid.addFluidToTank(destination, from, fluidToMove, true);
                                UtilFluid.removeFluidFromTank(source, to, fluidToMove, true);
                            }
                        }

                        else {

                            isSuccessful = false;
                        }
                    }
                    else {

                        isSuccessful = false;
                    }
                }
            }
        }
        return isSuccessful;
    }

    public static boolean moveFluid(FluidTank source, ForgeDirection from, IFluidHandler destination, int amount, boolean doMove) {

        boolean isSuccessful = false;

        if(source != null && source.getFluid() != null && destination != null) {

            if(UtilFluid.addFluidToTank(destination, from, source.getFluid(), false)) {

                if(source.getFluidAmount() >= amount) {

                    isSuccessful = true;

                    if(doMove) {

                        UtilFluid.addFluidToTank(destination, from, source.getFluid(), true);
                        source.setCapacity(amount);
                    }
                }
            }
        }

        return isSuccessful;
    }

    public static boolean moveFluid(IFluidHandler source, ForgeDirection from, IFluidHandler destination, ForgeDirection to, int amount, boolean doMove) {

        boolean isSuccessful = false;

        if(source != null && destination != null) {

            if(destination.getTankInfo(from) != null && source.getTankInfo(from) != null) {

                FluidStack fluidToMove = UtilFluid.removeFluidFromTankFluidStack(source, to, amount, false);

                if(fluidToMove != null) {

                    fluidToMove = fluidToMove.copy();

                    if(fluidToMove.amount >= amount) {

                        fluidToMove.amount = amount;

                        if(UtilFluid.addFluidToTank(destination, from, fluidToMove, false)) {

                            isSuccessful = true;

                            if(doMove) {

                                UtilFluid.addFluidToTank(destination, from, fluidToMove, true);
                                UtilFluid.removeFluidFromTank(source, to, fluidToMove, true);
                            }
                        }

                        else {

                            isSuccessful = false;
                        }
                    }
                    else {

                        isSuccessful = false;
                    }
                }
            }
        }
        return isSuccessful;
    }

    public static boolean addFluidToTank(IFluidHandler destination, ForgeDirection from, FluidStack fluid, boolean doMove) {

        if(fluid != null && destination != null) {

            if(destination.getTankInfo(from) != null) {

                for(FluidTankInfo info : destination.getTankInfo(from)) {

                    if(info != null) {

                        if(info.fluid != null) {

                            if(!(info.fluid.isFluidEqual(fluid))) {

                                break;
                            }
                        }

                        if(destination.canFill(from, fluid.getFluid())) {

                            if(destination.fill(from, fluid, false) != 0) {

                                if(doMove)
                                    destination.fill(from, fluid, true);

                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public static FluidStack removeFluidFromTankFluidStack(IFluidHandler destination, ForgeDirection from, int amount, boolean doMove) {

        ForgeDirection oppositeDirection = from.getOpposite();

        if(destination != null) {

            if(destination.getTankInfo(from) != null) {

                if(destination.getTankInfo(from) != null) {

                    for(FluidTankInfo info : destination.getTankInfo(oppositeDirection)) {

                        if(info != null) {

                            if(info.fluid != null) {

                                if(info.fluid.amount >= amount) {

                                    if(destination.canDrain(oppositeDirection, info.fluid.getFluid())) {

                                        if(destination.drain(oppositeDirection, info.fluid, false) != null) {

                                            if(doMove)
                                                return destination.drain(oppositeDirection, info.fluid, true);

                                            return destination.drain(oppositeDirection, info.fluid, false);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public static boolean removeFluidFromTank(IFluidHandler destination, ForgeDirection from, int amount, boolean doMove) {

        ForgeDirection oppositeDirection = from.getOpposite();
        boolean itWorked = false;

        if(destination != null) {

            if(destination.getTankInfo(from) != null) {

                if(destination.getTankInfo(from) != null) {

                    for(FluidTankInfo info : destination.getTankInfo(oppositeDirection)) {

                        if(info != null) {

                            if(info.fluid != null) {

                                if(info.fluid.amount >= amount) {

                                    if(destination.canDrain(oppositeDirection, info.fluid.getFluid())) {

                                        if(destination.drain(oppositeDirection, info.fluid, false) != null) {

                                            if(doMove)
                                                destination.drain(oppositeDirection, info.fluid, true);
                                            itWorked = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return itWorked;
    }

    public static boolean removeFluidFromTank(IFluidHandler destination, ForgeDirection from, Fluid fluid, int amount, boolean doMove) {

        return UtilFluid.removeFluidFromTank(destination, from, new FluidStack(fluid, amount), doMove);
    }

    public static boolean removeFluidFromTank(IFluidHandler destination, ForgeDirection from, FluidStack fluid, boolean doMove) {

        boolean itWorked = false;

        if(fluid != null && destination != null) {

            if(destination.getTankInfo(from) != null) {

                if(destination.getTankInfo(from) != null) {

                    for(FluidTankInfo info : destination.getTankInfo(from)) {

                        if(info != null) {

                            if(info.fluid != null) {

                                if(!(info.fluid.isFluidEqual(fluid))) {

                                    itWorked = false;
                                    break;
                                }
                            }

                            if(destination.canDrain(from, fluid.getFluid())) {

                                if(destination.drain(from, fluid, false) != null) {

                                    if(doMove)
                                        destination.drain(from, fluid, true);

                                    itWorked = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return itWorked;
    }
}
